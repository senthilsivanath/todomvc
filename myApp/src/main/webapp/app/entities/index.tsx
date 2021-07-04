import React from 'react';
import { Switch } from 'react-router-dom';

// eslint-disable-next-line @typescript-eslint/no-unused-vars
import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import D from './d';
import B from './b';
import C from './c';
import A from './a';
/* jhipster-needle-add-route-import - JHipster will add routes here */

const Routes = ({ match }) => (
  <div>
    <Switch>
      {/* prettier-ignore */}
      <ErrorBoundaryRoute path={`${match.url}d`} component={D} />
      <ErrorBoundaryRoute path={`${match.url}b`} component={B} />
      <ErrorBoundaryRoute path={`${match.url}c`} component={C} />
      <ErrorBoundaryRoute path={`${match.url}a`} component={A} />
      {/* jhipster-needle-add-route-path - JHipster will add routes here */}
    </Switch>
  </div>
);

export default Routes;
