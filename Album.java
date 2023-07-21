public class Album {
    private String title;
    private int releaseYear;
    private Song[] songs;

    public Album(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public int addSongs(Song[] songs) {
        if (this.songs == null)
            this.songs = new Song[0];
        int counter = 0;
        for (int k = 0; k < songs.length; k++) {
            if (songs[k] != null) {
                for (int m = 0; m < songs.length; m++) {
                    if (songs[m] != null && songs[k].isEqual(songs[m]) && k != m) {
                        counter++;
                        songs[m] = null;
                    }
                }
            }
        }

        int x = 0;
        Song[] tempArray = new Song[songs.length - counter];
        for (int k = 0; k < songs.length; k++) {
            if (songs[k] != null) {
                tempArray[x] = songs[k]; //axali simgerebis unikaluri array
                x++;
            }
        }

        Song[] allSongs = new Song[this.songs.length + tempArray.length]; //dzveli da axa1li simgerebis array
        int x3 = 0;
        for (int i = 0; i < this.songs.length; i++) {
            if (this.songs[i] != null) {
                allSongs[x3] = this.songs[i];
                x3++;
            }
        }
        for (int i = 0; i < tempArray.length; i++) {
            allSongs[x3] = tempArray[i];
            x3++;
        }
        int counter2 = 0;
        for (int k = 0; k < allSongs.length; k++) {
            if (allSongs[k] != null) {
                for (int m = 0; m < allSongs.length; m++) {
                    if (allSongs[m] != null && allSongs[k].isEqual(allSongs[m]) && k != m) {
                        counter2++;
                        allSongs[m] = null;
                    }
                }
            }
        }

        int x2 = 0;
        Song[] allSongsFinal = new Song[allSongs.length - counter2];
            for (int k = 0; k < allSongs.length; k++) {
            if (allSongs[k] != null) {
                allSongsFinal[x2] = allSongs[k]; //axali simgerebis unikaluri array
                x2++;
            }
        }
            this.songs = allSongsFinal;
        return (x - counter2);
    }

    public Song[] shuffle() {
        int arrayLength = songs.length;
        for (int i = 0; i < songs.length; i++) {
            int index = (int) (Math.random() * arrayLength);
            Song temp = songs[i];
            songs[i] = songs[index];
            songs[index] = songs[i];
        }
        return new Song[0];
    }
    public Song[] sortByTitle(boolean isAscending) {
        Song[] titleSorted = new Song[this.songs.length];
        for(int i = 0; i < this.songs.length; i++) {
            titleSorted[i] = this.songs[i];
        }
        for(int i = 0; i < titleSorted.length; i++){
            for(int j = i + 1; j < titleSorted.length; j++){
                if(titleSorted[i].getTitle().compareTo(titleSorted[j].getTitle()) > 0){
                    Song temp = titleSorted[i];
                    titleSorted[i] = titleSorted[j];
                    titleSorted[j]= temp;
                }
            }
        }
        if(isAscending == true) return titleSorted;
        else return reverse(songs);
    }

    public Song[] sortByDuration(boolean isAscending) {
            Song[] durationSorted = new Song[this.songs.length];
            for(int i = 0; i < this.songs.length; i++){
                durationSorted[i] = this.songs[i];
            }
            for(int i = 0; i < durationSorted.length; i++) {
                for (int j = i + 1; j < durationSorted.length; j++) {
                    if (this.songs[i].getDuration() > this.songs[j].getDuration()) {
                        Song temp = durationSorted[i];
                        durationSorted[i] = durationSorted[j];
                        durationSorted[j] = temp;
                    }
                }
            }
        if(isAscending == true) return durationSorted;
        else return reverse(songs);
    }
    public Song[] sortByReleaseYear(boolean isAscending) {
        Song[] releaseYearSorted = new Song[this.songs.length];
        for(int i = 0; i < this.songs.length; i++){
            releaseYearSorted[i] = this.songs[i];
        }
        for(int i = 0; i < releaseYearSorted.length; i++) {
            for(int j = i + 1; j < releaseYearSorted.length; j++)
                if (this.songs[i].getReleaseYear() > this.songs[j].getReleaseYear()) {
                    Song temp = releaseYearSorted[i];
                    releaseYearSorted[i] = releaseYearSorted[j];
                    releaseYearSorted[j]= temp;
                }
        }
        if(isAscending == true) return releaseYearSorted;
        else return reverse(songs);
    }
    public Song[] sortByPopularity(boolean isAscending) {
        Song[] likesSorted = new Song[this.songs.length];
        for(int i = 0; i < this.songs.length; i++){
            likesSorted[i] = this.songs[i];
        }
        for(int i = 0; i < likesSorted.length; i++) {
            for(int j = i + 1; j < likesSorted.length; j++)
                if (this.songs[i].getLikes() > this.songs[j].getLikes()) {
                    Song temp = likesSorted[i];
                    likesSorted[i] = likesSorted[j];
                    likesSorted[j]= temp;
                }
        }
        if(isAscending == true) return likesSorted;
        else return reverse(songs);
    }
    public static Song[] reverse(Song[] songs) {
        int k = songs.length - 1;
        Song[] newArray = new Song[songs.length];
        for(int i = 0; i < songs.length; i++) {
            newArray[i] = songs[k];
            k--;
        }
        return newArray;
    }

    public int sumOfLikes() {
        int sumOfLikes = 0;
        for (int i = 0; i < this.songs.length; i++) {
            if (this.songs != null) {
                sumOfLikes += this.songs[i].getLikes();
            }
        }
        return sumOfLikes;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("title:{" + title + "},Release year:{" + releaseYear + "},songs:{");
        for(int i = 0; i < songs.length; i++) {
            if(i != this.songs.length - 1) {
                builder.append(this.songs[i].toString() + "|");
            }
            else
                builder.append(this.songs[i].toString() + "}");
        }
        return builder.toString();
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Song[] getSongs() {
        return songs;
    }
}