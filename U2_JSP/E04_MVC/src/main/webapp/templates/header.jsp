<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta content='text/html; charset=UTF-8'>
        <title>${param["custom-title"]}</title>
        <style>
            html {
                position: relative;
                min-height: 100%;
            }
            body {
                margin-bottom: 60px;
            }
            .acad-container {
                padding-top: 1em;
                padding-bottom: 1em;
            }
            .acad-footer {
                position: absolute;
                bottom: 0;
                width: 100%;
                height: 60px;
                line-height: 60px; /* Vertically center the text there */
                background-color: #f5f5f5;
            }
        </style>
    </head>
    <body>
        <div class="container acad-container">