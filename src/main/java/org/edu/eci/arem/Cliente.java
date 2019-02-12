package org.edu.eci.arem;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import java.io.*;

//URL https://arep-parcial1.herokuapp.com/ la IP es 54.152.111.238
public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket clienteSocket = null;
		final int PORT = ServidorWeb.getPort();
		final String HOST = "54.152.111.238";
		BufferedReader in;
		PrintWriter out;
		try {
			clienteSocket = new Socket(HOST, PORT);
			in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
			out = new PrintWriter(clienteSocket.getOutputStream());
			

			String mensaje;
			while ((mensaje = in.readLine()) != null) {

				System.out.println(mensaje);
				if (!in.ready())
					break;

			}
			

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}