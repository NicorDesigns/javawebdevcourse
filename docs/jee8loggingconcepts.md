# 1. Understanding the Concepts of Logging


**Why do we need logging?** 

In web applications running in the cloud also known as distributed web applications we have to monitor our usage constantly and get insight into configuration changes, performance and data outages

We also have to track down and follow hard to use bugs often in distributed cloud based web servers for which we can not use our Eclipse Debugger

We will dig deeper into logging facades, logging API's and their implementations and we will learn how to apply logging to one of our example applications

**Why do we always add logging to our code?**

An analogy would be to leave breadcrumbs as in *Hansel and Gretel* fable so that we can find our way to the bug without getting lost in the forest of code which can happen in a debugger. 

It also helps us understand our code flow by adding logging and in that way it is kind of a layer of documentation embedded in the code for better insight.

The basic log statement is of course System.out.println() and is still a helpful tool today when doing development especially Test Driven Development but of course that will be no use in a production server.

That is why we use Logging Frameworks that are customizamizable, can be easily configured and of course can be hooked up to third party UI Monitoring tools and search packages to track down errors and bugs. 

### What Content do we want to see in Logs?

1. Any unexpected Runtime Exception as in the dreaded Null Pointer Exception and all the relevant information such as Stack Traces

2. Any expected Exception that you handle in a try-catch-block

3. Even non errors such as DB Connection Changes or configuration changes in production

4. When we follow an Pojo Object across micro-services we what to add logs to see where it is and its member variable values

5. We might want to see if a specific method was hit in a micro-service and what was its input parameters and return values

6. Sometimes we need to archive some specific events in our program because it is required by state regulation

### How are logs written?

Can end up in a file or a DB or third party cloud based tool, can be done to a bunch of different end point simultaneously, via http, sms or yes even websockets. Examples of third party tools associated with Cloud Based service such as AWS, GCP and MS Azure abound.

