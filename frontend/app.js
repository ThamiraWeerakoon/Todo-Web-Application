const API_BASE = 'http://localhost:8080/api/tasks';

const form = document.getElementById('taskForm');
const list = document.getElementById('taskList');

const loadTasks = async () => {
    const res = await fetch(API_BASE);
    const tasks = await res.json();
    list.innerHTML = '';
    tasks.forEach(task => {
        const div = document.createElement('div');
        div.className = 'task';
        div.innerHTML = `
      <div>
        <strong>${task.title}</strong><br>${task.description || ''}
      </div>
      <button onclick="completeTask(${task.id})">Done</button>
    `;
        list.appendChild(div);
    });
};

const completeTask = async (id) => {
    await fetch(`${API_BASE}/${id}/complete`, {method: 'PUT'});
    loadTasks();
};

form.addEventListener('submit', async (e) => {
    e.preventDefault();
    const title = document.getElementById('title').value;
    const description = document.getElementById('description').value;
    await fetch(API_BASE, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({title, description})
    });
    form.reset();
    loadTasks();
});

loadTasks();