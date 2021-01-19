package codes.mydna.rest.utils;

import com.kumuluz.ee.rest.beans.QueryParameters;

public class QueryParametersBuilder {

    private static final long maxLimit = 100L;
    private static final long defaultLimit = 10L;
    private static final long defaultOffset = 0L;

    public static QueryParameters buildDefault(String query) {
        return QueryParameters
                .query(query)
                .defaultOffset(defaultOffset)
                .defaultLimit(defaultLimit)
                .maxLimit(maxLimit)
                .build();
    }

    public static QueryParameters buildCustom(String query,
                                              long maxLimit,
                                              long defaultLimit,
                                              long defaultOffset){
        return QueryParameters
                .query(query)
                .defaultOffset(defaultOffset)
                .defaultLimit(defaultLimit)
                .maxLimit(maxLimit)
                .build();
    }

}
