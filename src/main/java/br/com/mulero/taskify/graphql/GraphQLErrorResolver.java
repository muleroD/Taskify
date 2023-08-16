package br.com.mulero.taskify.graphql;

import graphql.GraphQLError;
import graphql.GraphqlErrorException;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class GraphQLErrorResolver extends DataFetcherExceptionResolverAdapter {

    public static final String INPUT = "input";

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        // TODO: 16-08-2023 - Mulero: Implementar estrategia para recuperar os valores do input e incluir nas extensions

        if (ex instanceof GraphqlErrorException graphqlEx) {
            return GraphqlErrorException.newErrorException()
                    .message(graphqlEx.getMessage())
                    .cause(graphqlEx.getCause())
                    .sourceLocations(graphqlEx.getLocations())
                    .extensions(graphqlEx.getExtensions())
                    .path(graphqlEx.getPath())
                    .errorClassification(graphqlEx.getErrorType())
                    .build();
        }

        return super.resolveToSingleError(ex, env);
    }
}
