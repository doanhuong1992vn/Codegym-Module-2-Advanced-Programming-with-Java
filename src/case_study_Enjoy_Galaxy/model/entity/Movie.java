package case_study_Enjoy_Galaxy.model.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie {
    private static int count = 0;
    private long id;
    private String name;
    private String director;
    private String actors;
    private String movieGenre;
    private Date premiereDate;
    private int movieDuration;
    private String language;
    private String content;

    public Movie(String name, String director, String actors, String movieGenre,
                 String strPremiereDate, int movieDuration, String language, String content) throws ParseException {
        this.id = ++count;
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.movieGenre = movieGenre;
        this.premiereDate = new SimpleDateFormat("dd/MM/yyyy").parse(strPremiereDate);
        this.movieDuration = movieDuration;
        this.language = language;
        this.content = content;
    }

    public Movie(long id, String name, String director, String actors, String movieGenre, Date premiereDate, int movieDuration, String language, String content) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.movieGenre = movieGenre;
        this.premiereDate = premiereDate;
        this.movieDuration = movieDuration;
        this.language = language;
        this.content = content;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public Date getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(String premiereDate) throws ParseException {
        this.premiereDate = new SimpleDateFormat("dd/MM/yyyy").parse(premiereDate);
    }

    public String getStringPremiereDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(getPremiereDate());
    }

    public long getTimeOfPremiereDate() {
        return getPremiereDate().getTime();
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDetail() {
        return String.format("""
                        ID phim: %s
                        Tên phim: %s
                        Đạo diễn: %s
                        Diễn viên: %s
                        Thể loại: %s
                        Khởi chiếu: %s
                        Thời lượng: %d phút
                        Ngôn ngữ: %s
                        Nội dung: %s""",
                getId(),
                getName(),
                getDirector(),
                getActors(),
                getMovieGenre(),
                getStringPremiereDate(),
                getMovieDuration(),
                getLanguage(),
                getContent());
    }

    @Override
    public String toString() {
        return String.format("ID=%d: %s {Thể loại: %s; Khởi chiếu: %s; Thời lượng: %d phút}",
                getId(),
                getName(),
                getMovieGenre(),
                getStringPremiereDate(),
                getMovieDuration());
    }
}
