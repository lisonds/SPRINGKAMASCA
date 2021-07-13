package unsch.edu.pe;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import unsch.edu.pe.model.entity.Factura;
import unsch.edu.pe.model.entity.Ventas;
import unsch.edu.pe.repositore.FacturaRepository;
import unsch.edu.pe.repositore.VentasRepository;

@SpringBootApplication
public class ProyectoKamascaApplication implements CommandLineRunner{
	
	/*private VentasRepository repo;*/
	@Autowired
	private VentasRepository vent;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoKamascaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	System.out.println("vent: "+vent);
	
	GuardarVenta();
	}
	
	private void BuscarVentas() {
		List<Ventas> lista=vent.findAll();
		for(Ventas v:lista) {
			System.out.println("resultado"+v.getNumboleta()+" "+v.getProducto()+" "+v.getCosto()+" "+v.getFactura().getRuc());
		}
	}
	private void GuardarVenta() {
		Ventas venta=new Ventas();
		venta.setNumboleta("200");
		venta.setProducto("ILUMINACIONlISONDS");
		venta.setClasificacion("publicidad");
		venta.setFecha(new Date());
		venta.setCosto(300.0);
		venta.setCancelado(0);
		Factura factu=new Factura();
		factu.setIdfactura(0000000003);
		venta.setFactura(factu);
		vent.save(venta);	
	}
	/*CrudRepository*/
	/*
	public void Conteo() {
		long count=fact.count();
		System.out.println("total de categorias ="+count);
	}
	
	public void Guardar() {
		System.out.println("insertando un registro");
		Factura  fac= new Factura();
		fac.setRuc("000189789");
		
		
		fact.save(fac);
		
		
	}
	
	private void buscarPorId() {
		
		Optional<Factura> optional= fact.findById(1);
		if(optional.isPresent())
			System.out.println(optional.get());
		else
			System.out.println("ventas no encotradas");
	}
	
	private void Modificar() {
		Optional<Factura> optional= fact.findById(2);
		if(optional.isPresent()) {
			Factura fa=optional.get();
			fa.setRuc("123456987");
			fact.save(fa);
			
			System.out.println(optional.get());}
		else
			System.out.println("ventas no encotradas");
		}
	
	public void Elimnar() {
		System.out.println("Eliminando un registro");
		int idFactura=1;
		fact.deleteById(idFactura);
	}*/
	}
	
