package hockeystats.monolith.nhl_api.stats;

import reactor.core.publisher.Mono;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StatsApi {
  @GET("/api/v1/seasons")
  Mono<Response<StatsSeasons>> listSeasons();

  @GET("/api/v1/schedule")
  Mono<Response<Schedule>> getScheduleForDate(@Query("date") String date);

  @GET("/api/v1/teams/{teamId}/roster")
  Mono<Response<StatsRoster>> getTeamRoster(@Path("teamId") long teamId,
      @Query("season") String seasonId);
}
