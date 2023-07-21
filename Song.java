public class Song {
    public String title;
    public int releaseYear;
    public int duration;
    public int likes;

    public Song (String title, int releaseYear, int duration, int likes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = likes;
    }

    public Song (String title, int releaseYear, int duration) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = 0;
    }
    public Song (String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = 60;
        this.likes = 0;
    }

    public boolean changeDuration(int duration) {
        if(duration < 0 || duration > 720 || duration == this.duration) return false;
        else{
            this.duration = duration;
            return true;
        }
    }
    public void unlike(){
        if(likes == 0) return;
        this.likes -= 1;
    }

    public boolean isEqual(Song other){
        return this.title.equals(other.title) && this.releaseYear == other.releaseYear && this.duration == other.duration;
    }

    @Override
    public String toString() {
        return "title: " + title + ", Duration: " + (double) duration / 60 + " minutes, Release year: " + releaseYear + ", Likes: " + likes;
    }

    public String getTitle() {
        return title;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public int getDuration() {
        return duration;
    }
    public int getLikes() {
        return likes;
    }





}
