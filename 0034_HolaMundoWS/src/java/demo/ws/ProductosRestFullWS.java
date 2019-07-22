/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ws;

import demo.entity.ProductCode;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author david
 */
@Path("/codigoProducto")
@Stateless
public class ProductosRestFullWS {
    
    @PersistenceContext
    private EntityManager em;
    
    @GET
    @Path("descripcion/{codigo}")
    public String getDescripcion(@PathParam("codigo") String codigo){
        ProductCode p = em.find(ProductCode.class, codigo);
        if(p != null)
            return p.getDescription();
        else
            return "No existe el producto solicitado";
    }
    
    @GET
    @Path("{codigo}")
    public ProductCode getById(@PathParam("codigo") String codigo){
        ProductCode p = em.find(ProductCode.class, codigo);
        if(p != null)
            return p;
        else
            return null;
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void crearCodigoProducto(ProductCode p){
        System.out.println(p);
        System.out.println("Llega");
        em.persist(p);
    }
}
