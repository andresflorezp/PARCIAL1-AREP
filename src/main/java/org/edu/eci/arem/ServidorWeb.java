package org.edu.eci.arem;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import java.util.*;

public class ServidorWeb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		port(getPort());
		get("/", (req, resp) -> pageIndex(req, resp));
		get("/calculo", (req, resp) -> Calculo(req, resp));
		get("/results", (req, resp) -> answer(req, resp));

	}

	public static String pageIndex(Request req, Response resp) {
		String respuesta = "<!doctype html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
				+ "    <meta name=\"viewport\"\n"
				+ "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" + "    <title>AREP-Lab 2</title>\n"
				+ "</head>\n" + "<body>\n" + "    <h1>AREP-PARCIAL</h1>\n"
				+ "    <p>Este es un programa que calcula la sumatoria,multiplicatoria,minimo valor,maximo valor y te muestra la lista de numeros para iniciar de click en el siguiente\n"
				+ "        vinculo <a href=\"\\calculo\">Oprime</a>\n" + "    </p>\n" + "</body>\n" + "</html>";
		return respuesta;
	}

	public static String Calculo(Request req, Response resp) {
		String respuesta = "<!doctype html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
				+ "    <meta name=\"viewport\"\n"
				+ "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" + "    <title>Document</title>\n"
				+ "</head>\n" + "<body>\n" + "    <h1>AREP-PARCIAL1</h1>\n" + "    <br/>\n"
				+ "    <h2>Digita el conjunto de datos de la siguiente forma</h2>\n" + "    <p>Ej:\n"
				+ "        4;5.2;6;2.3;........;..\n" + "    </p>\n" + "    <form action=\"/results\">\n"
				+ "        <h3>Conjunto de datos numero 1</h3>\n"
				+ "        <input type=\"text\" placeholder=\"Numeros espaciados con ';'\" name=\"DataOne\">\n"
				+ "        <br><br><br>\n" + "        <input type=\"submit\" value=\"Calcular\">\n" + "\n"
				+ "    </form>\n" + "\n" + "</body>\n" + "</html>";
		return respuesta;
	}

	public static String answer(Request req, Response resp) {
		String set1 = req.queryParams("DataOne");
		System.out.println(set1);
		if(set1==null) {
			return "<!doctype html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
					+ "    <meta name=\"viewport\"\n"
					+ "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" + "    <title>Document</title>\n"
					+ "</head>\n" + "<body>\n" + "No se Puede Calcular nada si no ingresas Valores"+"\n" + "</body>\n" + "</html>";
		}
		
		String[] particion1 = set1.split(";");
		Calculate calc = new Calculate(particion1);
		ArrayList<Double> datas = calc.Data;
		double min = calc.calculate_min();

		double max = calc.calculate_max();
		double sum = calc.calculate_sum();
		double mult = calc.calculate_mult();

		String respuesta = "<!doctype html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
				+ "    <meta name=\"viewport\"\n"
				+ "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" + "    <title>Document</title>\n"
				+ "</head>\n" + "<body>\n" + "    <h1>AREP-PARCIAL</h1>\n" + "\n" + "[{\"maximo\":" + max + ","
				+ "\"minimo\":" + min + "," + "\"sumatoria\":" + sum + "," + "\"listaNumeros\":" + datas.toString()
				+ "," + "\"multiplicatoria\":" + mult + "}]" + "\n" + "\n" + "</body>\n" + "</html>";
		return respuesta;
	}

	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; // returns default port if heroku-port isn't set (i.e. on localhost)
	}

}