// script.js
document.addEventListener('DOMContentLoaded', () => {
  // ---------- TIMER ----------
  const timerEl = document.getElementById('timer');
  function updateTimer() {
    timerEl.textContent = new Date().toLocaleTimeString();
  }
  updateTimer();
  setInterval(updateTimer, 1000);

  // ---------- TODO (closure) ----------
  function todoManager() {
    let tasks = [];
    return {
      addTask(task) {
        tasks.push(task);
      },
      // remove first matching task (by value)
      removeTask(task) {
        const idx = tasks.indexOf(task);
        if (idx !== -1) tasks.splice(idx, 1);
      },
      // remove by index
      removeAt(index) {
        if (index >= 0 && index < tasks.length) tasks.splice(index, 1);
      },
      getTasks() {
        return tasks.slice();
      }
    };
  }

  const todo = todoManager();

  // UI elements
  const taskInput = document.getElementById('taskInput');
  const addBtn = document.getElementById('addTaskBtn');
  const removeBtn = document.getElementById('removeTaskBtn');
  const showBtn = document.getElementById('showTasks'); // optional
  const taskListEl = document.getElementById('taskList');

  // render tasks into the same card container, each with its own Remove button
  function renderTasks() {
    const tasks = todo.getTasks();
    taskListEl.innerHTML = '';

    if (tasks.length === 0) {
      const p = document.createElement('p');
      p.textContent = 'No tasks added yet.';
      taskListEl.appendChild(p);
      return;
    }

    tasks.forEach((t, idx) => {
      const li = document.createElement('li');
      li.style.display = 'flex';
      li.style.justifyContent = 'space-between';
      li.style.alignItems = 'center';
      li.style.marginBottom = '6px';

      const span = document.createElement('span');
      span.textContent = t;

      const btn = document.createElement('button');
      btn.type = 'button';
      btn.textContent = 'Remove';
      btn.style.marginLeft = '8px';
      btn.addEventListener('click', () => {
        // remove the clicked item by index then re-render
        todo.removeAt(idx);
        renderTasks();
      });

      li.appendChild(span);
      li.appendChild(btn);
      taskListEl.appendChild(li);
    });
  }

  // Add task: pushes into closure and renders immediately
  addBtn.addEventListener('click', () => {
    const v = taskInput.value.trim();
    if (!v) {
      alert('Please type a task to add.');
      return;
    }
    todo.addTask(v);
    taskInput.value = '';
    renderTasks();
  });

  // Remove task: if user typed a name, remove first match; if nothing typed, remove last task
  removeBtn.addEventListener('click', () => {
    const v = taskInput.value.trim();
    const tasksBefore = todo.getTasks().length;

    if (v) {
      todo.removeTask(v);
      const tasksAfter = todo.getTasks().length;
      if (tasksBefore === tasksAfter) {
        alert('Task not found (type the exact task text to remove it) or remove via the Remove button next to an item.');
      }
      taskInput.value = '';
      renderTasks();
      return;
    }

    // if nothing typed -> remove last
    const all = todo.getTasks();
    if (all.length === 0) {
      alert('No tasks to remove.');
      return;
    }
    todo.removeAt(all.length - 1);
    renderTasks();
  });

  // optional Show Tasks button (if present in your HTML)
  if (showBtn) {
    showBtn.addEventListener('click', () => {
      renderTasks();
    });
  }

  // ---------- CALCULATOR (operation map with arrow functions) ----------
  const num1El = document.getElementById('num1');
  const num2El = document.getElementById('num2');
  const opEl = document.getElementById('operation');
  const calcBtn = document.getElementById('calcBtn');
  const resultEl = document.getElementById('calcResult');

  // map of operations -> arrow functions
  const ops = {
    '+': (a, b) => a + b,
    '-': (a, b) => a - b,
    '*': (a, b) => a * b
  };

  calcBtn.addEventListener('click', () => {
    const n1 = parseFloat(num1El.value);
    const n2 = parseFloat(num2El.value);
    const op = (opEl && opEl.value) ? opEl.value : '+';

    if (Number.isNaN(n1) || Number.isNaN(n2)) {
      resultEl.textContent = 'Please enter valid numbers in both fields.';
      return;
    }

    const fn = ops[op];
    if (typeof fn !== 'function') {
      resultEl.textContent = 'Invalid operation selected.';
      return;
    }

    const res = fn(n1, n2);
    // show the result in same card container
    resultEl.textContent = 'Result: ' + res;
  });

  // initial render (if any tasks pre-exist)
  renderTasks();
});