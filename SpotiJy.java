public class SpotiJy {
    private Artist[] artists;

    public SpotiJy() {
        this.artists = new Artist[]{};
    }

    public Artist[] getArtists() {
        return this.artists;
    }

    public void addArtists(Artist[] artists) {
        int counter = 0;
        for (int k = 0; k < artists.length; k++) {
            if (artists[k] != null) {
                for (int m = 0; m < artists.length; m++) {
                    if (artists[m] != null && artists[k].equals(artists[m]) && k != m) {
                        counter++;
                        artists[m] = null;
                    }
                }
            }
        }
        int x = 0;
        Artist[] tempArray = new Artist[artists.length - counter];
        for (int k = 0; k < artists.length; k++) {
            if (artists[k] != null) {
                tempArray[x] = artists[k]; //axali artistebis unikaluri array
                x++;
            }
        }
        Artist[] allArtists = new Artist[tempArray.length + this.artists.length];
        int x3 = 0;
        for (int i = 0; i < this.artists.length; i++) {
            if (this.artists[i] != null) {
                allArtists[x3] = this.artists[i];
                x3++;
            }
        }
        for (int i = 0; i < tempArray.length; i++) {
            allArtists[x3] = tempArray[i];
            x3++;
        }
        int counter2 = 0;
        for (int k = 0; k < allArtists.length; k++) {
            if (allArtists[k] != null) {
                for (int m = 0; m < allArtists.length; m++) {
                    if (allArtists[m] != null && allArtists[k].isEqual(allArtists[m]) && k != m) {
                        counter2++;
                        allArtists[m] = null;
                    }
                }
            }
        }
        int x2 = 0;
        Artist[] allArtistsFinal = new Artist[allArtists.length - counter2];
        for (int k = 0; k < allArtists.length; k++) {
            if (allArtists[k] != null) {
                allArtistsFinal[x2] = allArtists[k];
                x2++;
            }
        }
        this.artists = allArtistsFinal;
    }

    public String[] getTopTrendingArtist() {
        Artist finalArtist = null;
        for (int i = 0; i < this.artists.length; i++) {
            if (this.artists[i] != null) {
                if (finalArtist == null)
                    finalArtist = this.artists[i];
                else if (finalArtist.totalLikes() > this.artists[i].totalLikes())
                    finalArtist = this.artists[i];
            }
        }
        return new String[]{finalArtist.getFirstName(), finalArtist.getLastName()};
    }

    public String getTopTrendingAlbum() {
        Album finalAlbum = null;
        for (int i = 0; i < this.artists.length; i++) {
            if (this.artists[i] != null) {
                for (int j = 0; j < this.artists[i].getAlbums().length; j++) {
                    if (this.artists[i].getAlbums()[j] != null) {
                        if (finalAlbum == null) {
                            finalAlbum = this.artists[i].getAlbums()[j];
                        } else if (finalAlbum.sumOfLikes() > this.artists[i].getAlbums()[j].sumOfLikes()) {
                            finalAlbum = this.artists[i].getAlbums()[j];
                        }
                    }
                }
            }
        }
        return finalAlbum.getTitle();
    }

    public String getTopTrendingSong() {
        Song finalSong = null;
        for (int i = 0; i < this.artists.length; i++) {
            if (this.artists[i] != null) {
                for (int j = 0; j < this.artists[i].getAlbums().length; j++) {
                    if (this.artists[i].getAlbums()[j] != null) {
                        for (int k = 0; k < this.artists[i].getAlbums()[j].getSongs().length; k++) {
                            if (this.artists[i].getAlbums()[j].getSongs()[k] != null) {
                                if (finalSong == null) {
                                    finalSong = this.artists[i].getAlbums()[j].getSongs()[k];
                                } else if (finalSong.getLikes() > this.artists[i].getAlbums()[j].getSongs()[k].getLikes()) {
                                    finalSong = this.artists[i].getAlbums()[j].getSongs()[k];
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < this.artists.length; i++){
            if(this.artists[i] != null) {
                for(int j = 0; j < this.artists[i].getSingles().length; j++) {
                    if(this.artists[i].getSingles()[j] != null) {
                        if(finalSong == null) {
                            finalSong = this.artists[i].getSingles()[j];
                        } else if (finalSong.getLikes() > this.artists[i].getSingles()[j].getLikes()) {
                            finalSong = this.artists[i].getSingles()[j];
                        }
                    }
                }
            }
        }
        return finalSong.getTitle();
    }
}