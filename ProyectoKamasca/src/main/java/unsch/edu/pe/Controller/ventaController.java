package unsch.edu.pe.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import unsch.edu.pe.model.entity.Factura;
import unsch.edu.pe.model.entity.Ventas;
import unsch.edu.pe.service.IventasService;




@Controller
@RequestMapping(value="/panel")
public class ventaController {
	
	@Autowired
	private IventasService serviceventas;
	@PostMapping("/save")
	public String GuardarVentas(Ventas ventas,BindingResult result) {
		if(result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
			}	
			return "views/ventasForm";
		}
		System.out.println("ventas= "+ventas);
		Factura fact=new Factura();
		fact.setIdfactura(0000000002);
		ventas.setFactura(fact);
		serviceventas.guardar(ventas);
		return "redirect:/panel/ventas";
	}
	
	@GetMapping("/form")
	public String formventas() {
		
		
		return "views/ventasForm";
	}
	
	/*	@GetMapping("/guarda")
	public String GuardarVentas() {
		Ventas ventas=new Ventas();
		ventas.setIdventas(6);
		ventas.setNumboleta("128");
		ventas.setProducto("gigantofrafiaLis");
		ventas.setClasificacion("giganto");
		ventas.setFecha(new Date());
		ventas.setCosto(305.20);
		ventas.setCancelado(0);
		Factura fac=new Factura();
		fac.setIdfactura(0000000001);
		ventas.setFactura(fac);
		serviceventas.guardar(ventas);
		return "views/ventas";
	}*/
	
	@GetMapping("/ventas")
	public String ventas(Model model) {
		
		List<Ventas> lista=serviceventas.buscarTodas();
		System.out.println(lista);
		model.addAttribute("Ventas", lista);
		
	
		
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
