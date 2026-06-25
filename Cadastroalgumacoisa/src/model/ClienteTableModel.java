package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private final String[] colunas = {"Nome", "Telefone", "Email", "Sexo"};
	private ArrayList<Cliente> clientes;
	
	public ClienteTableModel(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public int getRowCount() {
		return clientes.size();
	}
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente cliente = clientes.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return cliente.getNome();
		case 1:
			return cliente.getTelefone();
		case 2:
			return cliente.getEmail();
		case 3:
			return cliente.getSexo();
			default:
				return null;
		}
			}
	public String getColumnName(int column) {
		return colunas[column];
	}
	public void addCliente(Cliente cliente) {
		this.clientes.add(cliente);
		//notifica que a linha foi inserida
		fireTableRowsInserted(clientes.size() - 1, clientes.size() - 1);		
	}
	//metodo para buscar um cliente por nome
	public int buscarCliente(String nome) {
		for(int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getNome().equalsIgnoreCase(nome)) {
				return i;
			}
		}
		return -1; //retorna -1 se o cliente não for encontrado
	}
	
	//Metodo para remover um cliente pelo índice
	public void removerCliente(int indice) {
		if(indice >= 0 && indice < clientes.size()) {
			clientes.remove(indice);
			fireTableRowsDeleted(indice, indice);
		}
	}
	public void limparDados() {
		clientes.clear();
		fireTableDataChanged();
	}
	public Cliente getCliente(int index) {
		return clientes.get(index);
	}
	public void atualizarTabela(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
		fireTableDataChanged();
	}
		

}
