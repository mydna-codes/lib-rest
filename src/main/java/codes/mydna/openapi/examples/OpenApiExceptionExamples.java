package codes.mydna.openapi.examples;

public class OpenApiExceptionExamples {

    public static class Response {

        public static final String NOT_FOUND = "{\n" +
                "    \"message\":\"Entity of type '<ENTITY_TYPE>' with id '<ENTITY_ID>' not found!\"\n" +
                "    \"statusCode\":\"404\"\n" +
                "}";

        public static final String BAD_REQUEST = "{\n" +
                "    \"message\":\"<SOMETHING> is not valid, because <REASON>!\"\n" +
                "    \"statusCode\":\"400\"\n" +
                "}";

        public static final String INTERNAL_SERVER_ERROR = "{\n" +
                "    \"message\":\"Internal server error...\"\n" +
                "    \"statusCode\":\"500\"\n" +
                "}";

    }

}
