

const getAPI = async (url) => {
    const newurl = await fetch(url);
    if (newurl.status === 200) {
        const temp = await newurl.json();
        return temp;
    }
    return {};
}

const postAPI = async (url, body) => {
    const result = await fetch(url, {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    if (result.status === 201) { alert("添加成功") }
}

export { getAPI, postAPI }
