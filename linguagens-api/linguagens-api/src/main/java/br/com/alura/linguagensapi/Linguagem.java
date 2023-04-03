package br.com.alura.linguagensapi;

@Document(collection = "principais linguagens")
public class Linguagem {

    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;

    public Linguagem(){

    }

    public Linguagem(String title, String image, int ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getRanking() {
        return ranking;
    }

}
