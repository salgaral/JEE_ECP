package models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.daos.VotoDao;
import models.entities.Voto;
import models.utils.NivelEstudio;

public class VotoDaoJdbc extends GenericDaoJdbc<Voto, Integer> implements VotoDao {
    
	private Logger log = LogManager.getLogger(VotoDaoJdbc.class);

    private Voto create(ResultSet resultSet) {
        try {
            if (resultSet != null && resultSet.next()) {
                return new Voto(resultSet.getString(Voto.IP),
                        resultSet.getInt(Voto.VALOR),
                        (NivelEstudio) resultSet.getObject(Voto.NIVELESTUDIO));
            }
        } catch (SQLException e) {
            log.error("read: " + e.getMessage());
        }
        return null;
    }

    private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s VARCHAR(255), %s INT NOT NULL "
            + "%s INT NOT NULL, PRIMARY KEY (%s))";

    public static String sqlToCreateTable() {
        return String.format(SQL_CREATE_TABLE, Voto.TABLE, Voto.IP, Voto.VALOR, Voto.NIVELESTUDIO, Voto.ID);
    }

    private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s,%s) VALUES (%d,'%s','%s', %d)";

    @Override
    public void create(Voto voto) {
        this.updateSql(String.format(SQL_INSERT, Voto.TABLE, Voto.IP, Voto.VALOR, Voto.NIVELESTUDIO, Voto.ID, 
        		voto.getIp(), voto.getValor(), voto.getNivelestudio(), voto.getId()));
    }

    @Override
    public Voto read(Integer id) {
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Voto.TABLE, id));
        return this.create(resultSet);
    }

    private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s='%s', %d=%d WHERE ID=%d";

    @Override
    public void update(Voto voto) {
        this.updateSql(String.format(SQL_UPDATE, Voto.TABLE, Voto.IP, voto.getIp(),
                Voto.VALOR, voto.getValor(), Voto.NIVELESTUDIO, voto.getNivelestudio(), voto.getId()));
    }

    @Override
    public void deleteById(Integer id) {
        this.updateSql(String.format(SQL_DELETE_ID, Voto.TABLE, id));
    }

    @Override
    public List<Voto> findAll() {
        List<Voto> list = new ArrayList<Voto>();
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL, Voto.TABLE));
        Voto voto = this.create(resultSet);
        while (voto != null) {
            list.add(voto);
            voto = this.create(resultSet);
        }
        return list;
    }

}
