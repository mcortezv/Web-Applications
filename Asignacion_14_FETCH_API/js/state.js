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

export const deleteTask = async (id) => {
    await fetch(`${API_URL}?id=${id}`, {
        method: 'DELETE'
    });
    tasks = tasks.filter(t => t.id !== id);
    return tasks;
}

export const toggleTask = async (id) => {
    const task = tasks.find(t => t.id === id);
    if(!task) return;

    const updatedTask = { ...task, completed: !task.completed };

    const response = await fetch(API_URL, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(updatedTask)
    });

    const savedTask = await response.json();
    task.completed = savedTask.completed;
    return tasks;
}

export const editTask = async (id, newText) => {
    const task = tasks.find(t => t.id === id);
    if(!task) return;

    const updatedTask = { ...task, text: newText }

    const response = await fetch(API_URL, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(updatedTask)
    });
    
    const savedTask = await response.json();
    task.text = savedTask.text;
    return tasks;
}
