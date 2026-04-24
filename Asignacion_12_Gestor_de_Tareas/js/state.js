const API_URL = "http://localhost:8080/TasksAPI_war_exploded/api/task"

export let tasks = [];

export const getTasks = async () => {
    const response = await fetch(API_URL);
    tasks = await response.json();
    return tasks;
}

export const addTask = async (text) => {
    const response = await fetch(
        API_URL, 
        {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({ text: text, completed: false})
        }
    );

    const newTask = await response.json();
    tasks.push(newTask);
    return tasks;
}

export const deleteTask = (id) => {
    tasks = tasks.filter(t => t.id !== id);
    return tasks;
}

export const toggleTask = (id) => {
    const task = tasks.find(t => t.id === id);
    if(task){
        task.completed = !task.completed;
    } 
    return tasks;
}

export const editTask = (id, newTask) => {
    const task = tasks.find(t => t.id === id);
    if(task){
        task.text = newTask;
    } 
    return tasks;
}
