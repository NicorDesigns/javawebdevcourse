<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Charity Associate Support</title>
    </head>
    <body>
        <h2>Create a Registration</h2>
        <form method="POST" action="registrations" enctype="multipart/form-data">
            <input type="hidden" name="action" value="create"/>
            
            Subject<br/>
            <input type="text" name="subject"><br/><br/>
            Body<br/>
            <textarea name="body" rows="5" cols="30"></textarea><br/><br/>
            <b>Attachments</b><br/>
            <input type="file" name="file"/><br/><br/>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
