package cliente.view;
import java.util.Scanner;


import java.sql.ResultSet;
import java.sql.SQLException;
import cliente.control.clientes;
import cliente.entity.Cliente;
import control.Conexión;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.clienteFantasma;
public class clienteView {
		private clientes clientes;
		private Scanner scanner;
		private Conexión conexión;
		
		public clienteView(clientes clientes,Conexión conexion,Scanner scanner) {
			this.conexión = conexion;
			this.clientes = clientes;
			
			this.scanner = scanner;
		}
		
		public void addCliente() {
			
			Cliente cliente = clienteRegistro.ingresar(scanner);
			String sql = "Insert into Cliente (dNIcliente, nombreCliente, direccion, telefono) " + "values(?,?,?,?)";
			try {
				conexión.consulta(sql);
				conexión.getSentencia().setInt(1, cliente.getDNIcliente());
				conexión.getSentencia().setString(2, cliente.getNombreCliente());
				conexión.getSentencia().setString(3, cliente.getDireccion());
				conexión.getSentencia().setInt(4, cliente.getTelefono());
				conexión.modificacion();
			} catch (SQLException e) {
				System.out.println(e.getSQLState());
			}
			
	}
		
		public void listCliente()throws SQLException  {
				Cliente cliente;
				String sql = "select * from cliente ";
				conexión.consulta(sql);
				ResultSet resultSet = conexión.resultado();
				while (resultSet.next()) {
					cliente = new Cliente(resultSet.getInt("codCliente"), resultSet.getInt("dNIcliente"),
							resultSet.getString("nombreCliente"), resultSet.getString("direccion"), resultSet.getInt("telefono"));
					System.out.println(cliente);
				}
			}
		
		public void deleteCliente() throws SQLException{
			int codCliente = InputTypes.readInt("Ingrese el codigo del cliente", scanner);
			
				String sql = "delete " + "from cliente " + "where código = ?";
				conexión.consulta(sql);
				conexión.getSentencia().setInt(1, codCliente);
				conexión.modificacion();
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
			int codCliente = InputTypes.readInt("Código del cliente: ", scanner);
			String sql = "select * from Cliente where código = ?";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, codCliente);
			resultSet = conexión.resultado();
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
			clienteMenu.menúModificar(scanner, cliente);

			sql = "update cliente set DNIcliente = ?, nombreCliente = ?, direccion = ?, telefono = ? where código = ?";

			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, cliente.getDNIcliente());
			conexión.getSentencia().setString(2, cliente.getNombreCliente());
			conexión.getSentencia().setString(3, cliente.getDireccion());
			conexión.getSentencia().setInt(4, cliente.getTelefono());
			conexión.modificacion();
		}

	}