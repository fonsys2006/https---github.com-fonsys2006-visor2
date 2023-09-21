
package clases.consultas;

import clases.conexion.Conexionbd;
import clases.modelos.Producido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author FONSYS
 */
public class consultasproducido {
    private Conexionbd db;
    
    public consultasproducido(){      
    }
    
      public List<Producido> listadoproducidoayer(Date fechacierre, String zcodempresa){
        this.db = new Conexionbd(zcodempresa);
        List<Producido> listado= null;
        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(fechacierre);
        fechacierre = (java.sql.Date.valueOf(fecha));

        PreparedStatement ps = null;
        ResultSet rs;
        String consulta="select A.numerovehi,A.numero_pla,A.nit_propie,A.conductor,A.timbradas,A.codigogrup,A.timb_cajau,"
                        + "A.FECHA_cier,A.numeroviaj,A.pagoconduc,A.promedgrup,B.nombregrup from caumovcier A "
                        + "inner join caumaegrup B on A.codigogrup=B.codigogrup where A.fecha_cier=? ";
        try {
            Connection cn = db.getConexion();
          if (cn !=null){   
            ps = cn.prepareStatement(consulta);
            ps.setDate(1, fechacierre);
            rs= ps.executeQuery();
            listado= new LinkedList<>();
            //System.out.print(tercero.getCodigoter());
            while (rs.next()){
                Producido producido = new Producido();
                producido.setNumeroveh(rs.getString(1));
                producido.setNumeropla(rs.getString(2));
                producido.setTercero(rs.getString(3));
                producido.setConductor(rs.getString(4));
                producido.setTimbradas(rs.getFloat(5));
                producido.setGrupo(rs.getString(6));
                producido.setTimb_cajau(rs.getFloat(7));
                producido.setFechacier(rs.getDate(8));
                producido.setViajes(rs.getInt(9));
                producido.setPagoconduc(rs.getFloat(10));
                producido.setPromedgrup(rs.getFloat(11));
                producido.setNombregrupo(rs.getString(12));
                listado.add(producido);
            }
          }
          if(cn !=null) cn.close();
        } catch (Exception e) {
            //e.printStackTrace();
            //System.err.println("Error iniciarSesion: " + e);
        }finally {
            try {
                
               if(ps !=null) ps.close();    
            } catch (Exception e) {
                System.err.println("Error al consultar producido" + e);
            }
                
        }
     
        return  listado;   
    }    

      public List<Producido> listadoproducidohoy(Date fechacierre, String zcodempresa){
        this.db = new Conexionbd(zcodempresa);
        List<Producido> listado= null;
        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(fechacierre);
        fechacierre = (java.sql.Date.valueOf(fecha));

        PreparedStatement ps = null;
        ResultSet rs;
        String consulta="select B.numerovehi,B.numero_pla,A.codigoter,B.conductor,sum(B.timbradas) as timbradas,A.codigogrup, 0000000000.00 as timb_cajau,"
                        + "A.fecha as fecha_cier,sum(B.numeroviaj) as numeroviaj, 0000000000.00 as pagoconduc, 0000000000.00 as promedgrup,"
                        + "C.nombregrup from Genmovdoca A "
                        + "inner join caumovdode B on A.codigoconc=B.codigoconc and A.documento=B.documento "
                        + "inner join caumaegrup C on A.codigogrup=C.codigogrup where A.fecha=? and A.estado<>'A' group by B.numerovehi ";
        try {
            Connection cn = db.getConexion();
          if (cn !=null){   
            ps = cn.prepareStatement(consulta);
            ps.setDate(1, fechacierre);
            rs= ps.executeQuery();
            listado= new LinkedList<>();
            //System.out.print(tercero.getCodigoter());
            while (rs.next()){
                Producido producido = new Producido();
                producido.setNumeroveh(rs.getString(1));
                producido.setNumeropla(rs.getString(2));
                producido.setTercero(rs.getString(3));
                producido.setConductor(rs.getString(4));
                producido.setTimbradas(rs.getFloat(5));
                producido.setGrupo(rs.getString(6));
                producido.setTimb_cajau(rs.getFloat(7));
                producido.setFechacier(rs.getDate(8));
                producido.setViajes(rs.getInt(9));
                producido.setPagoconduc(rs.getFloat(10));
                producido.setPromedgrup(rs.getFloat(11));
                producido.setNombregrupo(rs.getString(12));
                listado.add(producido);
            }
          }
          if(cn !=null) cn.close();
        } catch (Exception e) {
            //e.printStackTrace();
            //System.err.println("Error iniciarSesion: " + e);
        }finally {
            try {
                
               if(ps !=null) ps.close();    
            } catch (Exception e) {
                System.err.println("Error al consultar producido" + e);
            }
                
        }
     
        return  listado;   
    }    

      public LocalDate ultimocierre(String zcodempresa){
        this.db = new Conexionbd(zcodempresa);
        LocalDate ultfec = LocalDate.now().minusDays(360);
        String fecha = String.valueOf(ultfec.getYear()) + "-" + String.valueOf(ultfec.getMonthValue()) + "-" + String.valueOf(ultfec.getDayOfMonth());
        Date ultfecha = (java.sql.Date.valueOf(fecha));

        PreparedStatement ps = null;
        ResultSet rs;
                String consulta="select fecha_cier from caumovcier  "
                        + "where fecha_cier>=? order by fecha_cier DESC limit 0,1 ";
        try {
            Connection cn = db.getConexion();
          if (cn !=null){   
            ps = cn.prepareStatement(consulta);
            ps.setDate(1, ultfecha);
            rs= ps.executeQuery();
            if (rs.next()) {
                ultfecha=(rs.getDate(1));
            }
          }
          if(cn !=null) cn.close();
        } catch (Exception e) {
            //e.printStackTrace();
            //System.err.println("Error iniciarSesion: " + e);
        }finally {
            try {               
               if(ps !=null) ps.close();    
            } catch (Exception e) {
                System.err.println("Error al consultar ultima fecha cierre" + e);
            }
                
        }
     
        return ultfecha.toLocalDate();   
    }   
      
}
