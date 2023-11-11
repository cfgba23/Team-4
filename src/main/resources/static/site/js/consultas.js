const apiUrl = 'http://localhost:8080/api/campaign/active';
const postData = {
    description:"mi campaña",
    name:"tomas",
    totalAmount:100000,
    campaignType:"PRIVATE"
};

fetch(apiUrl, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(postData)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error('Error:', error));



