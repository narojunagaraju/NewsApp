package com.nnaroju.newsapp.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.nnaroju.newsapp.domain.model.Article;
import com.nnaroju.newsapp.domain.model.Source;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class NewsDao_Impl implements NewsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Article> __insertionAdapterOfArticle;

  private NewsTypeConverter __newsTypeConverter;

  private final EntityDeletionOrUpdateAdapter<Article> __deletionAdapterOfArticle;

  public NewsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfArticle = new EntityInsertionAdapter<Article>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `Article` (`author`,`content`,`description`,`publishedAt`,`source`,`title`,`url`,`urlToImage`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Article entity) {
        if (entity.getAuthor() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getAuthor());
        }
        statement.bindString(2, entity.getContent());
        statement.bindString(3, entity.getDescription());
        statement.bindString(4, entity.getPublishedAt());
        final String _tmp = __newsTypeConverter().sourceToString(entity.getSource());
        statement.bindString(5, _tmp);
        statement.bindString(6, entity.getTitle());
        statement.bindString(7, entity.getUrl());
        statement.bindString(8, entity.getUrlToImage());
      }
    };
    this.__deletionAdapterOfArticle = new EntityDeletionOrUpdateAdapter<Article>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Article` WHERE `url` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Article entity) {
        statement.bindString(1, entity.getUrl());
      }
    };
  }

  @Override
  public Object upsert(final Article article, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfArticle.insert(article);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Article article, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfArticle.handle(article);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Article>> getArticles() {
    final String _sql = "SELECT * FROM Article";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"Article"}, new Callable<List<Article>>() {
      @Override
      @NonNull
      public List<Article> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPublishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "publishedAt");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfUrlToImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlToImage");
          final List<Article> _result = new ArrayList<Article>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Article _item;
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpContent;
            _tmpContent = _cursor.getString(_cursorIndexOfContent);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpPublishedAt;
            _tmpPublishedAt = _cursor.getString(_cursorIndexOfPublishedAt);
            final Source _tmpSource;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfSource);
            _tmpSource = __newsTypeConverter().stringToSource(_tmp);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpUrl;
            _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            final String _tmpUrlToImage;
            _tmpUrlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
            _item = new Article(_tmpAuthor,_tmpContent,_tmpDescription,_tmpPublishedAt,_tmpSource,_tmpTitle,_tmpUrl,_tmpUrlToImage);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getArticle(final String url, final Continuation<? super Article> $completion) {
    final String _sql = "SELECT * FROM Article WHERE url=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, url);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Article>() {
      @Override
      @Nullable
      public Article call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPublishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "publishedAt");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfUrlToImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlToImage");
          final Article _result;
          if (_cursor.moveToFirst()) {
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpContent;
            _tmpContent = _cursor.getString(_cursorIndexOfContent);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpPublishedAt;
            _tmpPublishedAt = _cursor.getString(_cursorIndexOfPublishedAt);
            final Source _tmpSource;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfSource);
            _tmpSource = __newsTypeConverter().stringToSource(_tmp);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpUrl;
            _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            final String _tmpUrlToImage;
            _tmpUrlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
            _result = new Article(_tmpAuthor,_tmpContent,_tmpDescription,_tmpPublishedAt,_tmpSource,_tmpTitle,_tmpUrl,_tmpUrlToImage);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Arrays.asList(NewsTypeConverter.class);
  }

  private synchronized NewsTypeConverter __newsTypeConverter() {
    if (__newsTypeConverter == null) {
      __newsTypeConverter = __db.getTypeConverter(NewsTypeConverter.class);
    }
    return __newsTypeConverter;
  }
}
