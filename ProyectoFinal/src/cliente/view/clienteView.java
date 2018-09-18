package cliente.view;
import java.util.Scanner;


import java.sql.ResultSet;
import java.sql.SQLException;
import cliente.control.clientes;
import cliente.entity.Cliente;
import control.Conexi�n;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.clienteFantasma;
public class clienteView {
		private clientes clientes;
		private Scanner scanner;
		private Conexi�n conexi�n;
		
		public clienteView(clientes clientes,Conexi�n conexion,Scanner scanner) {
			this.conexi�n = conexion;
			this.clientes = clientes;
			
			this.scanner = scanner;
		}
		
		public void addCliente() {
			
			Cliente cliente = clienteRegistro.ingresar(scanner);
			String sql = "Insert into Cliente (dNIcliente, nombreCliente, direccion, telefono) " + "values(?,?,?,?)";
			try {
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, cliente.getDNIcliente());
				conexi�n.getSentencia().setString(2, cliente.getNombreCliente());
				conexi�n.getSentencia().setString(3, cliente.getDireccion());
				conexi�n.getSentencia().setInt(4, cliente.getTelefono());
				conexi�n.modificacion();
			} catch (SQLException e) {
				System.out.println(e.getSQLState());
			}
			
	}
		
		public void listCliente()throws SQLException  {
				Cliente cliente;
				String sql = "select * from cliente ";
				conexi�n.consulta(sql);
				ResultSet resultSet = conexi�n.resultado();
				while (resultSet.next()) {
					cliente = new Cliente(resultSet.getInt("codCliente"), resultSet.getInt("dNIcliente"),
							resultSet.getString("nombreCliente"), resultSet.getString("direccion"), resultSet.getInt("telefono"));
					System.out.println(cliente);
				}
			}
		
		public void deleteCliente() throws SQLException{
			int codCliente = InputTypes.readInt("Ingrese el codigo del cliente", scanner);
			
				String sql = "delete " + "from cliente " + "where c�digo = ?";
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, codCliente);
				conexi�n.modificacion();
			}
		

		public clientes getClientes() {
			return clientes;
		}
		
		public void update() throws clienteFantasma, SQLException {
			ResultSet resultSet;
			Cliente cliente;
			String nombre;
			String direccion;
			int dni;
			int telefono;
			int codCliente = InputTypes.readInt("C�digo del cliente: ", scanner);
			String sql = "select * from Cliente where c�digo = ?";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, codCliente);
			resultSet = conexi�n.resultado();
			if (resultSet.next()) {
				nombre = resultSet.getString("nombre");
				dni = resultSet.getInt("DNI");
				telefono = resultSet.getInt("telefono");
				direccion = resultSet.getString("direccion");
				cliente = new Cliente(codCliente, dni, nombre, direccion, telefono);
			} else {
				throw new clienteFantasma();
			}

			System.out.println(cliente);
			clienteMenu.men�Modificar(scanner, cliente);

			sql = "update cliente set DNIcliente = ?, nombreCliente = ?, direccion = ?, telefono = ? where c�digo = ?";

			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, cliente.getDNIcliente());
			conexi�n.getSentencia().setString(2, cliente.getNombreCliente());
			conexi�n.getSentencia().setString(3, cliente.getDireccion());
			conexi�n.getSentencia().setInt(4, cliente.getTelefono());
			conexi�n.modificacion();
		}

	}