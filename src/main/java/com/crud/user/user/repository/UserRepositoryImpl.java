package com.crud.user.user.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.user.user.model.User;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    private JdbcTemplate jbdc;
    
    @Override
    public List<User> findAll() {
        String SQL = "select * from Usuario";
        return jbdc.query(SQL, BeanPropertyRowMapper.newInstance(User.class));

        //throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public int save(User user) {
        //String SQL = "exec regUser";
        String save=" INSERT INTO Usuario (nombre, apellido, correo, contrasena, fecha_registro,status) VALUES(?,?,?,?,GETDATE(),?)";
        return jbdc.update(save,new Object[]{user.getNombre(), user.getApellido(), user.getCorreo(),user.getContraseña(),user.getStatus()} );
        //throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public int update(User user) {
        String update=" UPDATE Usuario SET nombre=?, apellido=?, correo=?, contrasena=?, fecha_registro=GETDATE(), status=? where id=?";
        return jbdc.update(update, new Object[]{user.getNombre(), user.getApellido(), user.getCorreo(),user.getContraseña(),user.getStatus(),user.getId()});
        //throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(int id) {
        String delete="UPDATE Usuario Set status='0' where id=?";
        return jbdc.update(delete, new Object[]{id});
        //throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public User findById(int id) {
        String SQL="Select * from Usuario where id=?";
        List<Map<String, Object>> rows= jbdc.queryForList(SQL, id);
        if (rows.isEmpty()){ 
            Map<String, Object> row = rows.get(0);
            User u=new User();
            u.setId((int)row.get("id"));
            u.setNombre((String)row.get("nombre"));
            u.setApellido((String)row.get("apellido"));
            u.setCorreo((String)row.get("correo"));
            u.setContraseña((String)row.get("contrasena"));
            //u.setFecha_registro((String) row.get("fecha_registro")); <---esto
            //Mapeo de fechaRegistro
            //Date fecha_registro = (Date)row.get("fecha_registro");
            //u.getFecha_registro(fecha_registro);
            u.setStatus((int)row.get("status"));
            /*u.setId(rs.getInt("id"));
            u.setNombre(rs.getString("nombre"));
            u.setApellido(rs.getString("apellido"));
            u.setCorreo(rs.getString("correo"));
            u.setContraseña(rs.getString("<PASSWORD>_contraseña"));
            u.setStatus(rs.getInt("status"));*/
            return u;
        }else {
            return null;
        }
        //throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<User> findAllActive() {
        String SQL = "Select * from Usuario where status='1'";
        return jbdc.query(SQL, BeanPropertyRowMapper.newInstance(User.class));
        //throw new UnsupportedOperationException("Unimplemented method 'findAllActive'");
    }
    
}
