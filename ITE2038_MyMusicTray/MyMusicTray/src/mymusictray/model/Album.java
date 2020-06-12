package mymusictray.model;

import mymusictray.core.Context;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Album Entity
 *
 * @author Prev (0soo.2@prev.kr)
 */
public class Album extends StrongTypeModel implements ListableModel {

	/**
	 * Init table `album` and related tables `album_genre` and `album_artists` by SQL
	 * @throws SQLException
	 */
	static public void initTable() throws SQLException {
		Statement stmt = Context.getDatabaseDriver().getStatement();
		stmt.executeUpdate(
				"CREATE TABLE IF NOT EXISTS `album` (\n" +
						"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
						"  `title` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
						"  `release_date` date NOT NULL,\n" +
						"  `type` tinyint(4) NOT NULL,\n" +
						"  PRIMARY KEY (`id`)\n" +
						") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=1 ;\n"
		);
		stmt.executeUpdate(
				"CREATE TABLE IF NOT EXISTS `album_genre` (\n" +
						"  `album_id` int(11) NOT NULL,\n" +
						"  `genre` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
						"  PRIMARY KEY (`album_id`,`genre`)\n" +
						") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;\n"
		);
		stmt.executeUpdate(
				"CREATE TABLE IF NOT EXISTS `album_artists` (\n" +
						"  `album_id` int(11) NOT NULL,\n" +
						"  `artist_id` int(11) NOT NULL,\n" +
						"  PRIMARY KEY (`album_id`,`artist_id`),\n" +
						"  KEY `artist_id` (`artist_id`)\n" +
						") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;\n"
		);
	}

	// Album instance repository
	static private Map<Integer, Album> repository = new HashMap<>();

	/**
	 * Instead of creating a new instance each time,
	 *   returns an existing, already created instance with the same ID.
	 * @return Album instance
	 */
	static public Album that(int id, String title, String releaseDate, int type, List<String> genre) {
		if (repository.containsKey(id))
			return repository.get(id);
		else {
			Album newInstance = new Album(id, title, releaseDate, type, genre);
			repository.put(id, newInstance);
			return newInstance;
		}
	}

	/**
	 * Get all albums in database with artists
	 * @return List of Arist instance
	 */
	public static List<Album> getAllAlbums() {
		Map<Integer, Album> albumDict = new HashMap<>();

		try {
			ResultSet rs = Context.getDatabaseDriver().getStatement().executeQuery(
					"SELECT " +
							"artist.id AS artist_id, artist.name AS artist_name, artist.activity_start_date AS artist_act_start,\n" +
							"album.id AS album_id, album.title AS album_title, album.release_date AS album_release_date, album.type AS album_type \n," +
							"music.*, music_genre.genre AS music_genre\n," +
							"album_genre.genre AS album_genre\n" +
						"FROM album\n" +
						"LEFT JOIN album_artists ON album_artists.album_id = album.id\n" +
						"LEFT JOIN artist ON artist.id = album_artists.artist_id\n" +
						"LEFT JOIN music ON music.album_id = album.id\n" +
						"LEFT JOIN music_genre ON music_genre.music_id = music.id\n" +
						"LEFT JOIN album_genre ON album_genre.album_id = album.id;\n"
			);

			while (rs.next()) {
				Album albumModel = Album.that(
						rs.getInt("album_id"),
						rs.getString("album_title"),
						rs.getString("album_release_date"),
						rs.getInt("album_type"),
						null
				);

				// Add music's genre if not null and doesn't contain
				String albumGenre = rs.getString("album_genre");
				if (albumGenre != null && !albumModel.genre.contains(albumGenre))
					albumModel.genre.add(albumGenre);

				Artist artistModel = Artist.that(
						rs.getInt("artist_id"),
						rs.getString("artist_name"),
						rs.getString("artist_act_start")
				);

				if (!albumModel.artists.contains(artistModel))
					albumModel.artists.add(artistModel);

				Music musicModel = Music.that(
						rs.getInt("id"),
						rs.getString("title"),
						null,
						albumModel,
						rs.getInt("track_no"),
						null
				);

				// Add music's genre if not null and doesn't contain
				String musicGenre = rs.getString("music_genre");
				if (musicGenre != null && !musicModel.genre.contains(musicGenre))
					musicModel.genre.add(musicGenre);

				// Add music to album
				albumDict.put(albumModel.id, albumModel);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new ArrayList<>(albumDict.values());
	}


	/**
	 * Type of albums
	 *   1 : REGULAR
	 *   2 : MINI
	 *   3: SINGLE
	 */
	static public final int TYPE_REGULAR = 1;
	static public final int TYPE_MINI = 2;
	static public final int TYPE_SINGLE = 3;

	/**
	 * Convert integer type to readable string
	 * @param type: Type of album
	 * @return Readable string
	 */
	static public String getReadableType(int type) {
		switch (type) {
			case TYPE_REGULAR:
				return "REGULAR";
			case TYPE_MINI:
				return "MINI";
			case TYPE_SINGLE:
				return "SINGLE";
			default:
				return null;
		}
	}





	/**
	 * Title of this album
	 */
	public String title;

	/**
	 * Release date of this album
	 */
	public String releaseDate;

	/**
	 * Type of this album (REGULAR/MINI/SINGLE)
	 */
	public int type;

	/**
	 * Artist list of this album
	 */
	public List<Artist> artists;

	/**
	 * Music list of this album
	 */
	public List<Music> musics;

	/**
	 * Genre list of this album
	 */
	public List<String> genre;


	/**
	 * Constructor of Album Model.
	 *   Generally used in result of selection
	 * @param id
	 * @param title
	 * @param releaseDate
	 * @param type
	 * @param genre
	 */
	public Album(int id,
				 String title,
				 String releaseDate,
				 int type,
				 List<String> genre) {

		super("album");
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.type = type;

		this.artists = new ArrayList<>();
		this.musics = new ArrayList<>();

		if (genre == null)
			genre = new ArrayList<>();

		this.genre = genre;
	}

	/**
	 * Constructor of Album Model with no id (= not saved to database yet)
	 *   Generally used to make new album
	 * @param title
	 * @param releaseDate
	 * @param type
	 */
	public Album(String title,
				 String releaseDate,
				 int type) {

		this(-1, title, releaseDate, type, null);
	}

	/**
	 * Get string version of artists to print pretty.
	 * @return Joined string of artist list
	 */
	public String getArtistsString() {
		if (this.artists.size() == 0) return "";

		StringBuilder sb = new StringBuilder();
		for (Artist artist: this.artists) {
			sb.append(artist.name);
			sb.append(',');
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	/**
	 * Get readable type instead of integer
	 * @return Text of type
	 */
	public String getReadableType() {
		return getReadableType(this.type);
	}

	/**
	 * Get string version of genre
	 * @return Joined string of genre list
	 */
	public String getGenreString() {
		return String.join(",", this.genre);
	}


	/**
	 * Add genre to album and save to database.
	 * 	 Insert tuple to `album_genre` table, and then add genre to `this.genre` property.
	 * @param genre: Genre to insert
	 */
	public void addGenreAndSave(String genre) {
		try {
			PreparedStatement stmt = Context.getConnection().prepareStatement("INSERT INTO `album_genre`(`album_id`, `genre`) VALUES (?, ?)");
			stmt.setInt(1, this.id);
			stmt.setString(2, genre);
			stmt.executeUpdate();

			this.genre.add(genre);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get attribute name and value set that is not a key.
	 * @return (name-value) set of attributes
	 */
	@Override
	public Map<String, String> getSubAttributes() {
		Map<String, String > ret = new HashMap<>();
		ret.put("title", title);
		ret.put("release_date", releaseDate);
		ret.put("type", Integer.toString(type));
		return ret;
	}

	/**
	 * Return ID of this model to show identifying number
	 * @return id
	 */
	@Override
	public int getID() {
		return this.id;
	}

	/**
	 * Return name of this model to show readable string
	 * @return title (similar value to name)
	 */
	@Override
	public String getName() {
		return this.title;
	}
}
