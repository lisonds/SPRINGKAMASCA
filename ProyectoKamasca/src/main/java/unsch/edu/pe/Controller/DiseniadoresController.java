package unsch.edu.pe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import unsch.edu.pe.model.entity.Diseniador;
import unsch.edu.pe.service.IDiseniadorService;

@Controller
@RequestMapping(value = "/panel")
public class DiseniadoresController {
	@Autowired
	private IDiseniadorService diseServi;
	
	
	@GetMapping("/disenia")
	public String Diseniadores() {

		return "views/usuarios";
	}
	
	@GetMapping("/disenia/from")
	public String DiseniadoresFrom() {

		return "views/diseniadorFrom";
	}
	
	@PostMapping("/disenia/save")
	public String Guardar(Diseniador diseniador,BindingResult result) {
		if(result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
			}	
			return "views/diseniadorFrame";
		}
		System.out.println("Diseniador :"+diseniador);
		diseServi.guardar(diseniador);
		return "views/diseniadorFrom";
	}
	
	/*
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
	}*/
}
