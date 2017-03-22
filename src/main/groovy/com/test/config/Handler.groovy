package com.test.config


import com.amazonaws.serverless.exceptions.ContainerInitializationException
import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse
import com.amazonaws.serverless.proxy.spring.SpringLambdaContainerHandler
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler

/**
 * Created by karthirockz on 22/03/17.
 */
public class Handler implements RequestHandler<AwsProxyRequest, AwsProxyResponse> {
    SpringLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler
    boolean isinitialized = false

    public AwsProxyResponse handleRequest(AwsProxyRequest awsProxyRequest, Context context) {
        if (!isinitialized) {
            isinitialized = true
            try {
                handler = SpringLambdaContainerHandler.getAwsProxyHandler(AppConfig.class)
            } catch (ContainerInitializationException e) {
                e.printStackTrace()
                return null
            }
        }
        return handler.proxy(awsProxyRequest, context)
    }
}
