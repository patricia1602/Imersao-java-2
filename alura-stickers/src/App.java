import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // fazer uma conexão HTTP e buscar os top 250 filmes
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.listaDeFilmes(body);

        // exibir e manipular os dados
        var geradora = new GeradoraDeFigurinhas();
        for (Map<String, String> filme : listaDeFilmes) {
            // System.out.println(filme.get("title"));
            // System.out.println(filme.get("image"));
            // System.out.println(filme.get("imDbRating"));
            // System.out.println();

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            geradora.cria(inputStream, nomeArquivo);

            // System.out.println("\u001b[1m" + "\u001b[36m" + filme.get("title"));
            // System.out.println(filme.get("image"));
            System.out.println(filme.get(titulo));

            // double rating = Double.parseDouble(filme.get("imDbRating")); // Convertendo a
            // string em double
            // int star = (int) rating; // Convertendo o double em int
            // for (int i = 0; i <= star; i++) { // Escrevendo estrelas na classificação o
            // "<=" é para arredondar conforme
            // solicitado
            // System.out.print("⭐");

                    System.out.println(body);

        }
        // System.out.println("\n");
    }
}
