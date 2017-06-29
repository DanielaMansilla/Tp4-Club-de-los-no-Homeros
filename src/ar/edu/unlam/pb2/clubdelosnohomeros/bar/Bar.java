package ar.edu.unlam.pb2.clubdelosnohomeros.bar;

import java.util.ArrayList;
import java.util.TreeSet;

import ar.edu.unlam.pb2.clubdelosnohomeros.cliente.Cliente;
import ar.edu.unlam.pb2.clubdelosnohomeros.cliente.ComparadorClientePorEdad;

public class Bar {

	private TreeSet<Cliente> clientes;
	private Boolean abierto;

	public Bar() {
		this.clientes = new TreeSet<Cliente>();
		this.abierto = false;
	}

	public Boolean barAbierto() {
		return this.abierto;
	}

	public void abrir() {
		this.abierto = true;

	}

	public void cerrar() {
		this.abierto = false;
		this.clientes = new TreeSet<Cliente>();
	}

	public TreeSet<Cliente>getClientes() throws BarCerradoException{
		if(!barAbierto()) throw new BarCerradoException();
		return this.clientes;
	}
	
	public ArrayList<Cliente>getClientesOrdenadosPorEdad()throws BarCerradoException{
		if(!barAbierto()) throw new BarCerradoException();
		ArrayList<Cliente>clientesOrdenadosPorEdad=new ArrayList<>();
		clientesOrdenadosPorEdad.addAll(this.getClientes());
		clientesOrdenadosPorEdad.sort(new ComparadorClientePorEdad());
		return clientesOrdenadosPorEdad;
	}
		
		public void ingresoCliente(Cliente cliente)throws BarCerradoException{
			if(!barAbierto()) throw new BarCerradoException();
			this.clientes.add(cliente);
		}
		
		
		public void salidaCliente(Cliente cliente) throws BarCerradoException{
			if(!barAbierto())throw new BarCerradoException();
			this.clientes.remove(cliente);
		}
		
	}
	

