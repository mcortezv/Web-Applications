const URL_API = 'https://rickandmortyapi.com/api'

export async function getCharacters(page = 1, filters ={}) {
    let url = `${URL_API}/character?page=${page}`

    if (filters.name) url += `&name=${filters.name}`;

    if (filters.status && filters.status !== 'all') url += `&status=${filters.status}`;

    try{
        const response = await fetch(url);
        return await response.json();
    } catch (error){
        return [];
    }
}