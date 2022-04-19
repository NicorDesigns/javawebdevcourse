### Clustering our JEE 8 Web App Module using Sessions


##### [Clustering Using Sessions Start Branch](https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-session-management-start)

#### 1. Clustering our Web Application using Session

Clustering is done by running the same web application on a multitude of servers or instances of servers running in a service center a.k.a the "cloud"
This provides resiliencies and robustness to your application.

With the advent of Cloud Services such as Amazon Web Services, Google Cloud Platform and Microsoft Azure a whole new spectrum of technologies and frameworks had to be developed to ensure that web service and cloud micro services stay in sync accross the globe and multiple databases stay consitently up to date.

To mention a few: RabbitMQ, Reddis that usually works together with older Messaging Protocols to communicate such as AMPQP/STOMP, JMS and MSMQ.

Staying in sync also involve balancing loads and processing accross sessions and VM for which a basic understanding is required

In this tutorial we will look at how to maintain session state between clustered web applications 



#### 2. Using Session Ids in a Cluster

In a cluster the workload is distributed accross all the Tomcat Instances or Nodes running in the service centers or cloud setup. This is usually done by assigning the Sessions to the various Tomcat instances, known as "sticky sessions".

The technology required here is known as a "Load Balancer" that act as an orchestrator that manages these sticky sessions: [Tomcat Load Balncing](https://tomcat.apache.org/tomcat-9.0-doc/balancer-howto.html) the Tomcat documentations mentions:

1.  Using the JK 1.2.x native connector
2.  Using Apache HTTP Server 2.x with mod_proxy

[Tomcat Connectors](https://tomcat.apache.org/connectors-doc/)

#### 3. Understanding Session Replication and Failover 

### From the official Tomcat documentation:

To enable session replication in Tomcat, three different paths can be followed to achieve the exact same thing:

1.  Using session persistence, and saving the session to a shared file system (PersistenceManager + FileStore)
2.  Using session persistence, and saving the session to a shared database (PersistenceManager + JDBCStore)
3.  Using in-memory-replication, using the SimpleTcpCluster that ships with Tomcat (lib/catalina-tribes.jar + lib/catalina-ha.jar)

Tomcat can perform an all-to-all replication of session state using the `DeltaManager` or perform backup replication to only one node using the `BackupManager`. The all-to-all replication is an algorithm that is only efficient when the clusters are small. For larger clusters, you should use the BackupManager to use a primary-secondary session replication strategy where the session will only be stored at one backup node.  
Currently you can use the domain worker attribute (mod_jk > 1.2.8) to build cluster partitions with the potential of having a more scalable cluster solution with the DeltaManager (you'll need to configure the domain interceptor for this). In order to keep the network traffic down in an all-to-all environment, you can split your cluster into smaller groups. This can be easily achieved by using different multicast addresses for the different groups. A very simple setup would look like this:

```
        DNS Round Robin
               |
         Load Balancer
          /           \
      Cluster1      Cluster2
      /     \        /     \
  Tomcat1 Tomcat2  Tomcat3 Tomcat4
```

What is important to mention here, is that session replication is only the beginning of clustering. Another popular concept used to implement clusters is farming, i.e., you deploy your apps only to one server, and the cluster will distribute the deployments across the entire cluster. This is all capabilities that can go into with the FarmWarDeployer (s. cluster example at `server.xml`)

In the next section will go deeper into how session replication works and how to configure it.


Check in the end Git branch of this slide show 

##### [Clustering Using Sessions Finish Branch](https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-session-management-finish)

    

