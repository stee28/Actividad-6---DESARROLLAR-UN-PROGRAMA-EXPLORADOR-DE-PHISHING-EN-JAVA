import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Ruta del archivo a analizar
        String archivo = "C:\\Users\\carl_\\Downloads\\steeven.txt";
        ;

        // Mapa para almacenar las palabras clave y sus valores
        Map<String, Integer> palabrasValores = new HashMap<>();
        palabrasValores.put("enlace", 3);
        palabrasValores.put("link", 3);
        palabrasValores.put("cuenta", 3);
        palabrasValores.put("contraseña", 3);
        palabrasValores.put("alerta", 3);
        palabrasValores.put("seguridad", 3);
        palabrasValores.put("premio", 3);
        palabrasValores.put("regalo", 3);
        palabrasValores.put("proteger", 3);
        palabrasValores.put("whatsapp", 2);
        palabrasValores.put("facebook", 3);
        palabrasValores.put("instagram", 2);
        palabrasValores.put("amazon", 2);
        palabrasValores.put("twitter", 2);
        palabrasValores.put("google", 3);
        palabrasValores.put("paypal", 3);
        palabrasValores.put("banco", 3);
        palabrasValores.put("peligro", 3);
        palabrasValores.put("urgente", 3);
        palabrasValores.put("codigo", 3);
        palabrasValores.put("reembolso", 3);
        palabrasValores.put("gratis", 3);
        palabrasValores.put("cupon", 3);
        palabrasValores.put("descuento", 3);
        palabrasValores.put("verificar", 3);
        palabrasValores.put("felicidades", 1);
        palabrasValores.put("factura", 1);
        palabrasValores.put("copia", 1);
        palabrasValores.put("notificacion", 1);
        palabrasValores.put("expira en 3 dias", 2);
        palabrasValores.put("la contraseña de su cuenta ha caducado", 3);
        palabrasValores.put("se requiere verificacion", 3);
        palabrasValores.put("su cuenta ha sido bloqueada", 3);

        // Nuevas palabras clave y sus valores
        palabrasValores.put("oferta exclusiva", 3);
        palabrasValores.put("ganador", 2);
        palabrasValores.put("premio garantizado", 3);
        palabrasValores.put("actualizar información", 3);
        palabrasValores.put("verificación de seguridad", 3);
        palabrasValores.put("urgente: acción requerida", 3);
        palabrasValores.put("lotería", 2);
        palabrasValores.put("herencia", 3);
        palabrasValores.put("urgente: su cuenta será cerrada", 3);
        palabrasValores.put("su cuenta fue comprometida", 3);
        palabrasValores.put("confirme su identidad", 3);
        palabrasValores.put("trato especial", 2);
        palabrasValores.put("¡gratis ahora!", 3);
        palabrasValores.put("compra ahora", 2);
        palabrasValores.put("mejor precio", 2);

        // Mapa para almacenar la suma de puntos de cada palabra clave encontrada
        Map<String, Integer> totalAcumulado = new HashMap<>();

        // Mapa para almacenar el número de ocurrencias de cada palabra clave encontrada
        Map<String, Integer> ocurrencias = new HashMap<>();

        // Se lee el archivo y se buscan las palabras clave
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                for (Map.Entry<String, Integer> entry : palabrasValores.entrySet()) {
                    String palabra = entry.getKey();
                    int valor = entry.getValue();
                    if (linea.toLowerCase().contains(palabra.toLowerCase())) {
                        totalAcumulado.put(palabra, totalAcumulado.getOrDefault(palabra, 0) + valor);
                        ocurrencias.put(palabra, ocurrencias.getOrDefault(palabra, 0) + 1);
                    }
                }
            }

            // Se muestra información para las palabras clave encontradas
            for (Map.Entry<String, Integer> entry : ocurrencias.entrySet()) {
                String palabra = entry.getKey();
                int numOcurrencias = entry.getValue();
                int total = totalAcumulado.getOrDefault(palabra, 0);
                System.out.println(palabra + " (Ocurrencias: " + numOcurrencias + ", Total de puntos: " + total + ")");
            }

            // Se calcula y se muestra en pantalla el total de puntos para todo el mensaje de texto
            int totalPuntos = totalAcumulado.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("\nTotal de puntos para todo el mensaje de texto: " + totalPuntos);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}