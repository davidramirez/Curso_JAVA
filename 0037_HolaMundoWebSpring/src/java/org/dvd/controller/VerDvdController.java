/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dvd.controller;

import javax.validation.Valid;
import org.dvd.model.DVDItem;
import org.dvd.repository.DVDItemsRepository;
import org.dvd.service.TiendaServiceLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author david
 */
@Controller
public class VerDvdController {

    @Autowired
    private TiendaServiceLocal tiendaService;

    public VerDvdController() {
        System.out.println("*************Instanciando VerDvdController****************");
    }
    
    @RequestMapping("/")
    public String inicio(Model model) {
        model.addAttribute("saludo", "Bienvenido a nuestra tienda online!");
        model.addAttribute("linea1", "Los mejores dvds del mercado ");
        return "index";
    }

    @RequestMapping("/dvd/detalle/{id}")
    public String verProducto(@PathVariable("id") int id, Model model) {
        DVDItem dvd = tiendaService.getDVD(id);
        model.addAttribute("dvd", dvd);
        return "detalleDvd";
    }

    @RequestMapping("/dvd/listado")
    public String listarProductos(Model model) {
        model.addAttribute("dvds", tiendaService.getAllDVDs());
        return "listadoDvd";
    }

    @RequestMapping(value = "/dvd/nuevo", method
            = RequestMethod.GET)
    public String getCrearNuevoProductoFormulario(Model model) {
        DVDItem dvd = new DVDItem();
        model.addAttribute("dvdNuevo", dvd);
        return "nuevoDvd";
    }

    @RequestMapping(value = "/dvd/nuevo",
            method = RequestMethod.POST)
    public String procesarCrearNuevoProductoFormulario(
            @ModelAttribute("dvdNuevo") @Valid DVDItem dvd, BindingResult res, Model model) {
        
        System.out.println("hay errores? " + res.hasErrors());
        if(res.hasErrors()){
            return "nuevoDvd";
        }
        
        if(!tiendaService.addDVD(dvd)){
            model.addAttribute("error", "Ya hay un dvd con el mismo id");
            return "nuevoDvd";
        }
        model.addAttribute("exitoAdd", "El dvd se ha añadido con éxito");
        return listarProductos(model);
        
        //return "redirect:/dvd/lista";
    }
}
