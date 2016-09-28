package example.app1;

import java.sql.SQLException;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Database extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "userdetails.db";
	private static final int DATABASE_VERSION = 1;
	private Dao<NewUsersDAO, Integer> userDao = null;
	private RuntimeExceptionDao<NewUsersDAO, Integer> userRuntimeDao = null;

	public Context context;

	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			Log.i(Database.class.getName(), "onCreate");
			TableUtils.createTable(connectionSource, NewUsersDAO.class);

		} catch (SQLException e) {
			Log.e(Database.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
			int oldVersion, int newVersion) {
		try {
			Log.i(Database.class.getName(), "onUpgrade");

			TableUtils.dropTable(connectionSource, NewUsersDAO.class, true);

			onCreate(db, connectionSource);
		} catch (SQLException e) {
			Log.e(Database.class.getName(), "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}

	// USER DETAILS
	public Dao<NewUsersDAO, Integer> getDao() throws SQLException {
		if (userDao == null) {
			userDao = getDao(NewUsersDAO.class);
		}
		return userDao;
	}

	public RuntimeExceptionDao<NewUsersDAO, Integer> getUsersDao() {
		if (userRuntimeDao == null) {
			userRuntimeDao = getRuntimeExceptionDao(NewUsersDAO.class);
		}
		return userRuntimeDao;
	}

	// method for insert data
	public int addData(NewUsersDAO Users) {
		Log.d("DBAddData", "Onclick");
		RuntimeExceptionDao<NewUsersDAO, Integer> dao = getUsersDao();
		int i = dao.create(Users);
		return i;
	}

	public NewUsersDAO getByEmail(String email, String password) {
		try {
			Database helper = new Database(context);
			RuntimeExceptionDao<NewUsersDAO, Integer> userDao = helper
					.getUsersDao();
			QueryBuilder<NewUsersDAO, Integer> qb = userDao.queryBuilder();

			Where<NewUsersDAO, Integer> where = qb.where();
			where.eq("email", email.toString());
			// and
			where.and();
			where.eq("password", password.toString());
			PreparedQuery<NewUsersDAO> pq = qb.prepare();
			return userDao.queryForFirst(pq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public NewUsersDAO getByEmail(String email) {
		try {
			Database helper = new Database(context);
			RuntimeExceptionDao<NewUsersDAO, Integer> userDao = helper
					.getUsersDao();
			QueryBuilder<NewUsersDAO, Integer> qb = userDao.queryBuilder();

			Where<NewUsersDAO, Integer> where = qb.where();
			where.eq("email", email.toString());
			// and

			PreparedQuery<NewUsersDAO> pq = qb.prepare();
			return userDao.queryForFirst(pq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void close() {
		super.close();
		userDao = null;
		userRuntimeDao = null;
	}
}
