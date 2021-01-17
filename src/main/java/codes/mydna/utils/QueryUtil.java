package codes.mydna.utils;

import com.kumuluz.ee.rest.beans.QueryFilter;
import com.kumuluz.ee.rest.beans.QueryParameters;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class QueryUtil {

    public static QueryParameters removeLimitAndOffset(QueryParameters queryParameters){
        QueryParameters qp = new QueryParameters();
        qp.setOrder(queryParameters.getOrder());
        qp.setFilters(queryParameters.getFilters());
        qp.setFields(queryParameters.getFields());
        return qp;
    }

    public static void addOrReplaceFilter(QueryParameters queryParameters, QueryFilter filter) {

        if(queryParameters == null) {
            queryParameters = new QueryParameters();
        }

        if (queryParameters.getFilters() != null) {
            boolean filterExists = queryParameters
                    .getFilters()
                    .stream()
                    .anyMatch(queryFilter -> queryFilter.getField().equals(filter.getField()));

            if (filterExists) {
                queryParameters.setFilters(queryParameters.getFilters().stream()
                        .map(queryFilter -> {
                            // Replace filter if it already exists
                            if (queryFilter.getField().equals(filter.getField())) {
                                return filter;
                            }
                            return queryFilter;
                        }).collect(Collectors.toList()));
            } else {
                queryParameters.getFilters().add(filter);
            }
        } else {
            queryParameters.setFilters(new ArrayList<>());
            queryParameters.getFilters().add(filter);
        }
    }

    public static void addFilterIfNotExist(QueryParameters queryParameters, QueryFilter filter) {

        if(queryParameters == null) {
            queryParameters = new QueryParameters();
        }

        if (queryParameters.getFilters() != null) {
            boolean filterExists = queryParameters
                    .getFilters()
                    .stream()
                    .anyMatch(queryFilter -> queryFilter.getField().equals(filter.getField()));

            if (!filterExists) {
                queryParameters.getFilters().add(filter);
            }
        } else {
            queryParameters.setFilters(new ArrayList<>());
            queryParameters.getFilters().add(filter);
        }
    }
}
