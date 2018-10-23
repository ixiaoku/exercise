package quietProxy;

public class TestMovie {

	public static void main(String[] args) {
		RealMovie realmovie = new RealMovie();

        Movie movie = new Cinema(realmovie);

        movie.play();
	}
}
