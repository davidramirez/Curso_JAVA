/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.ws;

import demo.entity.ProductCode;
import demo.ws.excepciones.ProductoException;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author david
 */
@WebService(serviceName = "SaludoWebService")
public class SaludoWebService {

    @PersistenceContext
    private EntityManager em;
    /**
     * This is a sample web service operation
     */
    @WebMethod(exclude = true)
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    public String saludar(String nombre){
        return "hola " + nombre;
    }
    
    public ProductCode getProductCodeById(String codigo) throws ProductoException{
        ProductCode pc = em.find(ProductCode.class, codigo);
        
        if(pc == null)
            throw new ProductoException("No existe");
        
        return pc;
    }
    
    public List<ProductCode> getListProductCodes(){
        return em.createNamedQuery("ProductCode.findAll").getResultList();
    }
}
