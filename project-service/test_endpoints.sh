# curl -X POST http://localhost:8080/projects \
#     -H "Content-Type: application/json" \
#     -d '{"projectId": 44433, "projectName": "New Project 1", "durationInMonths": 12, "numberOfResources":40, "projectStatus":"DONE"}'

# curl -X PUT http://localhost:8080/projects/12345/changeStatus \
#     -H "Content-Type: application/json" \
#     -d "CHANGED"

curl -X DELETE http://localhost:8080/projects/12345/ \
    -H "Content-Type: application/json"
