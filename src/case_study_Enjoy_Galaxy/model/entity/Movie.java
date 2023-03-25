package case_study_Enjoy_Galaxy.model.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie {
    private String title;
    private String director;
    private String actors;
    private String movieGenre;
    private Date premiereDate;
    private long movieDuration;
    private String language;
    private String content;

    public Movie(String title, String director, String actors, String movieGenre,
                 String premiereDate, long movieDuration, String language, String content) throws ParseException {
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.movieGenre = movieGenre;
        this.premiereDate = new SimpleDateFormat("dd/MM/yyyy").parse(premiereDate);
        this.movieDuration = movieDuration;
        this.language = language;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public long getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(long movieDuration) {
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

    @Override
    public String toString() {
        return String.format("""
                        Tên phim: %s
                        Đạo diễn: %s
                        Diễn viên: %s
                        Thể loại: %s
                        Khởi chiếu: %s
                        Thời lượng: %d
                        Ngôn ngữ: %s
                        Nội dung: %s""",
                getTitle(),
                getDirector(),
                getActors(),
                getMovieGenre(),
                getStringPremiereDate(),
                getMovieDuration(),
                getLanguage(),
                getContent());
    }
}
