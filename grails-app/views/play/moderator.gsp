<%--
  Created by IntelliJ IDEA.
  User: corra
  Date: 16.05.2020
  Time: 10:31
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <asset:javascript src="utility.js"/>
    <title>Play as Moderator</title>
</head>

<body>

<h1 class="display-3">Be the moderator!</h1>

<div class="card">
    <div class="card-body">
        <g:each status="i" var="question" in="${questions}">
            <h1 class="card-text">Question ${i+1}: ${question.questionText}</h1>
            <div id="shuffle${i+1}" class="card-text list-group">
                <a href="#" id="correct-answer${i+1}" onclick="markAsCorrectAnswer(${i+1})" class="list-group-item list-group-item-action">${question.correct}</a>
                <a href="#" id="wrong-answer${i+1}${i}" onclick="markAsWrongAnswer(${i+1}${i})" class="list-group-item list-group-item-action">${question.second}</a>
                <a href="#" id="wrong-answer${i+1}${i+1}" onclick="markAsWrongAnswer(${i+1}${i+1})" class="list-group-item list-group-item-action">${question.third}</a>
                <a href="#" id="wrong-answer${i+1}${i+2}" onclick="markAsWrongAnswer(${i+1}${i+2})" class="list-group-item list-group-item-action">${question.fourth}</a>
            </div>
            <button onclick="toggleVisibility(${i+1})" id="show-hide-button${i+1}" class="btn-primary" href="#" class="card-link">Show Answer</button>
            <button onclick="clearQuestion(${i})" id="show-hide-button${i+1}" class="btn-secondary" href="#" class="card-link">Clear Question</button>
            <script>
                shuffleQuestions(${i+1})
            </script>
        </g:each>
    </div>
</div>


</body>
</html>