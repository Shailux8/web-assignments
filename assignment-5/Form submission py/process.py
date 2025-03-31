#!/usr/bin/env python3

import cgi

# Required for CGI execution
print("Content-Type: text/html\n")  

# Get form data
form = cgi.FieldStorage()
name = form.getvalue("name")
email = form.getvalue("email")

# Display response
print(f"""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form Submission Result</title>
</head>
<body>
    <h2>Form Submitted Successfully!</h2>
    <p><strong>Name:</strong> {name}</p>
    <p><strong>Email:</strong> {email}</p>
</body>
</html>
""")
