import { Link } from "react-router-dom";
import "./Dashboard.css";

function Dashboard() {
  return (
    <div className="dashboard">

      <h1 className="title">React API Dashboard</h1>

      <div className="card-container">

        <Link to="/local" className="card">
          <h3>Local Users</h3>
          <p>Fetch data from local JSON file</p>
        </Link>

        <Link to="/users" className="card">
          <h3>Users API</h3>
          <p>Fetch users from JSONPlaceholder API</p>
        </Link>

        <Link to="/posts" className="card">
          <h3>Fake API Posts</h3>
          <p>Load posts using Axios</p>
        </Link>

      </div>

    </div>
  );
}

export default Dashboard;