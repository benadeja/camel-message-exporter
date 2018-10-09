camel-message-exporter
======================

Route 1 : Exporting messages on IBM MQ to the file system - this might be handy in situations where you have a producer 
application that is posting messages to IBM MQ but the consuming application is not ready to consume yet.
So by using this utility I can export messages from IBM MQ and save to the filesystem in whichever format 
is required to lighten the load on the MQ infrastrucure.

Route 2 : Route to read these messages from the file system and post them to an IBM MQ Queue,
which will be handy to repost messages to the MQ infrastructure when the consuming application is ready.
