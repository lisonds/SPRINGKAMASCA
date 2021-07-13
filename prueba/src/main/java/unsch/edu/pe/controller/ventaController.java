package unsch.edu.pe.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import unsch.edu.pe.model.dao.IVentasDao;


@Controller
@RequestMapping(value="/panel")
public class ventaController {
	
	private IVentasDao ventasDao;
	
	@GetMapping("/ventas")
	public String ventas(Model model) {
		
		model.addAttribute("Ventas",ventasDao.findAll());
		/*
		List<Ventas> Lista=getVentas();
		model.addAttribute("Ventas", Lista);
		*/
		
		return "views/ventas";
	}
	

	/*voy recibir valores de html*/
	@PostMapping("/save")
	public String crear(@RequestParam("numBoleta") Integer numBoleta,
			@RequestParam("producto") String producto,
			@RequestParam("clasificacion") String clasificacion,
			@RequestParam("fechaVenta") Date fechaVenta,
			@RequestParam("precio") Integer precio,
			@RequestParam("cancelado") Integer cancelado) {
		System.out.println("numero de boleta: "+numBoleta);
		System.out.println("producto: "+producto);
		System.out.println("clasificacion: "+clasificacion);
		System.out.println("fecha de venta: "+fechaVenta);
		System.out.println("precio: "+precio);
		System.out.println("Cancelado: "+cancelado);
		return "views/ventas";
	}
	
	
	/*
	private List<Ventas> getVentas(){
		SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
		List<Ventas> lista=new LinkedList<Ventas>();
		
		try{
			Ventas venta1=new Ventas();
			
			venta1.setNumBoleta(20568);
			venta1.setProducto("Gigantografias CL");
			venta1.setClasificacion("Giagantografias");
			venta1.setFecha(sdf.parse("08-02-2021"));
			venta1.setCosto(156.50);
			venta1.setCancelado(1);
			
			Ventas venta2=new Ventas();
			
			venta2.setNumBoleta(20569);
			venta2.setProducto("panel publicitario");
			venta2.setClasificacion("Giagantografias");
			venta2.setFecha(sdf.parse("08-02-2021"));
			venta2.setCosto(160.50);
			venta2.setCancelado(0);
			
			Ventas venta3=new Ventas();
			
			venta3.setNumBoleta(20570);
			venta3.setProducto("Gigantografias XL");
			venta3.setClasificacion("Giagantografias");
			venta3.setFecha(sdf.parse("08-02-2021"));
			venta3.setCosto(112.50);
			venta3.setCancelado(1);
			
			Ventas venta4=new Ventas();
			
			venta4.setNumBoleta(20571);
			venta4.setProducto("Gigantografias S");
			venta4.setClasificacion("Giagantografias");
			venta4.setFecha(sdf.parse("08-02-2021"));
			venta4.setCosto(100.00);
			venta4.setCancelado(0);
			
			lista.add(venta1);
			lista.add(venta2);
			lista.add(venta3);
			lista.add(venta4);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e.getMessage());
		}
		
		
		
		return lista;
	}
	*/
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, false));
		
	}

}
