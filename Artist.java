public class Artist {
    private String firstName;
    private String lastName;
    private int birtYear;
    private Album[] albums;
    private Song[] singles;

    public Artist(String firstName, String lastName, int birtYear, Album[] albums, Song[] singles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birtYear = birtYear;
        this.albums = albums;
        this.singles = singles;
    }

    public Song mostLikedSong() {
        Song finalSong = null;
        for (int i = 0; i < this.albums.length; i++) {
            if (this.albums[i] != null) {
                for (int j = 0; j < this.albums[i].getSongs().length; j++) {
                    if (this.albums[i].getSongs()[j] != null) {
                        if (finalSong == null) {
                            finalSong = this.albums[i].getSongs()[j];
                        } else if (this.albums[i].getSongs()[j].getLikes() > finalSong.getLikes()) {
                            finalSong = this.albums[i].getSongs()[j];
                        }
                    }
                }
            }
        }
        for(int i = 0; i < this.singles.length; i++) {
            if(finalSong == null){
                finalSong = this.singles[i];
            }
            else if(this.singles[i] != null && this.singles[i].getLikes() > finalSong.getLikes()) {
                finalSong = this.singles[i];
            }
        }
        return finalSong;
    }
    public Song leastLikedSong() {
        Song leastLiked = null;
        for(int i = 0; i < this.albums.length; i++) {
            if(this.albums[i] != null) {
                for(int j = 0; j < this.albums[i].getSongs().length; j++) {
                    if(this.albums[i].getSongs()[j] != null) {
                        if(leastLiked == null) {
                            leastLiked = this.albums[i].getSongs()[j];
                        } else if (this.albums[i].getSongs()[j].getLikes() < leastLiked.getLikes()) {
                            leastLiked = this.albums[i].getSongs()[j];
                        }
                    }

                }
            }
        }
        for(int i = 0; i < this.singles.length; i++) {
            if(this.singles[i] == null) {
                leastLiked = this.singles[i];
            } else if (this.singles[i] != null && this.singles[i].getLikes() < leastLiked.getLikes()) {
                leastLiked = this.singles[i];
            }
        }
        return leastLiked;
    }
    public int totalLikes() {
        int albumLikes = 0;
        int singlesLikes = 0;
        for (int i = 0; i < this.albums.length; i++) {
            for (int j = 0; j < this.albums[i].getSongs().length; j++) {
                albumLikes = this.albums[i].getSongs()[j].getLikes();
            }
        }
        for (int i = 0; i < this.singles.length; i++) {
            singlesLikes = this.singles[i].getLikes();
        }
        int totalLikes = singlesLikes + albumLikes;
        return totalLikes;
    }
    public boolean isEqual(Artist other) {
        return this.firstName.equals(other.firstName) && this.lastName.equals(other.lastName) && this.birtYear == other.birtYear;
    }
    public String toString() {
        return "name: " + firstName + lastName + ",Birth year: " + birtYear + ",Total likes: " + totalLikes();
    }


    public String getFirstName(){return firstName;}
    public String getLastName() {return lastName;}
    public int getBirtYear() {return birtYear;}
    public Album[] getAlbums() {return albums;}
    public Song[] getSingles() {return singles;}

}