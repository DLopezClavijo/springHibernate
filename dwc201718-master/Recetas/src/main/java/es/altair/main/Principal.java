package es.altair.main;

import java.util.List;
import java.util.Scanner;

import es.altair.bean.Usuario;
import es.altair.dao.UsuarioDAO;
import es.altair.dao.UsuarioDAOImplJDBC;

public class Principal {

	private static Scanner sc = new Scanner(System.in);

	private static UsuarioDAO uDAO = new UsuarioDAOImplJDBC();

	public static void main(String[] args) {
//		// INSERTAR
//		Usuario usu = new Usuario("Alumno Usu", "Apellidos USU", "alumusu", "alumusu123", "alumusu@gmail.com", 1, 1);
//		if (uDAO.insertar(usu))
//			System.out.println("Usuario Insertado");
//		else
//			System.out.println("No se ha podido insertar al usuario");
//
//		// LISTAR, OBTENER Y ACTUALIZAR
//		listadoUsuarios();
//		System.out.println("Seleccione Usuario para Actualizar (ID): ");
//		int idUsuario = sc.nextInt();
//		Usuario usuAct = uDAO.obtener(idUsuario);
//		if (usuAct != null) {
//			usuAct.setNombre(usuAct.getNombre() + "_EXT");
//			if (uDAO.actualizar(usuAct))
//				System.out.println("Usuario actualizado");
//			else
//				System.out.println("No se ha podido actualizar al usuario");
//		} else
//			System.out.println("Error al obtener el usuario a actualizar");
//
//		// BORRADO
//		listadoUsuarios();
//		System.out.println("Seleccione Usuario para Borrar (ID): ");
//		int idUsuarioB = sc.nextInt();
//		if (uDAO.borrar(idUsuarioB))
//			System.out.println("Usuario Borrado");
//		else
//			System.out.println("No se ha podido borrar al usuario");
		
//		// MOSTRAR USUARIOS TIPO 1
//		List<Usuario> usuarios = uDAO.mostrarUsuariosAcceso(1);
//		for (Usuario usuario : usuarios) {
//			System.out.println(usuario);
//		}
		
		System.out.println("Login: ");
		String login = sc.nextLine();
		System.out.println("Password: ");
		String password = sc.nextLine();
		
		if (uDAO.comprobarSQL1(login, password))
			System.out.println("Login Correcto");
		else
			System.out.println("Login Incorrecto");
		
		if (uDAO.comprobarSQL2(login, password))
			System.out.println("Login Correcto");
		else
			System.out.println("Login Incorrecto");
		
		sc.close();
	}

	private static void listadoUsuarios() {
		List<Usuario> usuarios = uDAO.listarTodos();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}

}
